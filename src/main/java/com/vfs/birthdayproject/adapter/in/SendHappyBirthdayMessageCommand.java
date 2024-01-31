package com.vfs.birthdayproject.adapter.in;

import com.vfs.birthdayproject.domain.usecase.SendHappyBirthdayMessageUseCase;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@ShellComponent
public class SendHappyBirthdayMessageCommand {

    final SendHappyBirthdayMessageUseCase useCase;

    public SendHappyBirthdayMessageCommand(SendHappyBirthdayMessageUseCase useCase) {
        this.useCase = useCase;
    }

    @ShellMethod(key = "send-happy-birthday-message")
    public String execute(@ShellOption(defaultValue = "") String inputDate){
        final LocalDate dateTime;
        if(inputDate.isEmpty()){
            dateTime = LocalDate.now();
        } else {
            dateTime = LocalDate.parse(inputDate, DateTimeFormatter.ISO_DATE);
        }

        useCase.execute(dateTime);
        return "Process date "+ dateTime.format(DateTimeFormatter.ISO_DATE);
    }
}
