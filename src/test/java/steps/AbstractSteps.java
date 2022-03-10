package steps;

import common.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

public class AbstractSteps extends ScenarioSteps {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractSteps.class);

    protected WebElementFacade getWebElementByFieldName(String fieldName, AbstractPage page) {
        try {
            Field field = page.getClass().getDeclaredField(fieldName);
            field.trySetAccessible();
            return (WebElementFacade) field.get(page);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            LOG.error(String.format("Cannot get element %s on page %s", fieldName, page.getClass().getSimpleName()), e);
            throw new RuntimeException(String.format("Element '%s' is not declared for class '%s'", fieldName,
                    page.getClass().getSimpleName()));
        }
    }
}
