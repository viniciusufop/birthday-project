package com.vfs.birthdayproject.adapter.in;

import com.vfs.birthdayproject.adapter.in.exception.InvalidInputDataException;
import com.vfs.birthdayproject.adapter.in.util.LocalDateMapper;
import com.vfs.birthdayproject.domain.usecase.SendHappyBirthdayMessageUseCase;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.vfs.birthdayproject.adapter.in.util.InConstants.INPUT_DATE_DEFAULT;
import static com.vfs.birthdayproject.adapter.in.util.InConstants.INPUT_DATE_HELP;

@ShellComponent
public class SendHappyBirthdayMessageCommand {

    private final SendHappyBirthdayMessageUseCase useCase;
    private final LocalDateMapper mapper;

    public SendHappyBirthdayMessageCommand(SendHappyBirthdayMessageUseCase useCase, LocalDateMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @ShellMethod(key = "send-happy-birthday-message")
    public String execute(@ShellOption(defaultValue = INPUT_DATE_DEFAULT, help = INPUT_DATE_HELP) String inputDate){
        try {
            final LocalDate date = mapper.getLocalDateBasedInInputDate(inputDate);
            useCase.execute(date);
            return "Process date "+ date.format(DateTimeFormatter.ISO_DATE);
        } catch (InvalidInputDataException e) {
            return e.getMessage();
        }
    }
}
