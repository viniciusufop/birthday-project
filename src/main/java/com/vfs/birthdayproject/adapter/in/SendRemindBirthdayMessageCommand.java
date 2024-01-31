package com.vfs.birthdayproject.adapter.in;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@ShellComponent
public class SendRemindBirthdayMessageCommand {

    @ShellMethod(key = "send-remind-birthday-message")
    public String execute(@ShellOption(defaultValue = "") String inputDate){
        final LocalDate dateTime;
        if(inputDate.isEmpty()){
            dateTime = LocalDate.now();
        } else {
            dateTime = LocalDate.parse(inputDate, DateTimeFormatter.ISO_DATE);
        }

        return "Process date "+ dateTime.format(DateTimeFormatter.ISO_DATE);
    }
}
