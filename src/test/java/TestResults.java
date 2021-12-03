import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class TestResults implements TestWatcher {
    Log log = new Log();

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        TestWatcher.super.testDisabled(context, reason);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        String testName = context.getDisplayName();
        log.info(testName + "BAŞARILI OLDU");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        String testFailedCause = cause.getMessage();
        log.error(testName + "HATA! :" + testFailedCause);
    }
}
