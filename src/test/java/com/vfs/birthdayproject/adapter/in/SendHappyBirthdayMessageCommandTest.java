package com.vfs.birthdayproject.adapter.in;

import com.vfs.birthdayproject.BeanTestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.context.annotation.Import;
import org.springframework.shell.test.ShellAssertions;
import org.springframework.shell.test.ShellTestClient;
import org.springframework.shell.test.ShellTestClient.InteractiveShellSession;
import org.springframework.shell.test.autoconfigure.ShellTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@ShellTest
@Import(BeanTestConfiguration.class)
@AutoConfigureDataJpa
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class SendHappyBirthdayMessageCommandTest {
    @Autowired
    ShellTestClient client;

    @Test
    void shouldExecuteTheCommand() {
        InteractiveShellSession session = client
                .interactive()
                .run();

        await().atMost(2, TimeUnit.SECONDS).untilAsserted(() -> {
            ShellAssertions.assertThat(session.screen())
                    .containsText("shell");
        });

        session.write(session.writeSequence().text("send-happy-birthday-message --inputDate 2012-12-12")
                .carriageReturn().build());
        await().atMost(2, TimeUnit.SECONDS).untilAsserted(() -> {
            ShellAssertions.assertThat(session.screen())
                    .containsText("Process date 2012-12-12");
        });
    }

    @Test
    void shouldReturnsMessageToInvalidParameterValue() {
        InteractiveShellSession session = client
                .interactive()
                .run();

        await().atMost(2, TimeUnit.SECONDS).untilAsserted(() -> {
            ShellAssertions.assertThat(session.screen())
                    .containsText("shell");
        });

        session.write(session.writeSequence().text("send-happy-birthday-message --inputDate invalid")
                .carriageReturn().build());
        await().atMost(2, TimeUnit.SECONDS).untilAsserted(() -> {
            ShellAssertions.assertThat(session.screen())
                    .containsText("Invalid inputDate parameter [invalid]. The standard is YYYY-MM-DD.");
        });
    }
}
