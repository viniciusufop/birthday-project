package com.vfs.birthdayproject.adapter.in;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@ShellComponent
public class SendRemindBirthdayMessageCommand {

    @ShellMethod(key = "send-remind-birthday-message")
    public String execute(@ShellOption(defaultValue = "", help = "informs the date that you want to process in the format YYYY-MM-DD. If not informed, the app will consider the current date") String inputDate){
        final LocalDate date;
        if(inputDate.isEmpty()){
            date = LocalDate.now();
        } else {
            try {
                date = LocalDate.parse(inputDate, DateTimeFormatter.ISO_DATE);
            }catch (DateTimeParseException ex){
                return String.format("Invalid inputDate parameter [%s]. The standard is YYYY-MM-DD.", inputDate);
            }
        }

        return "Process date "+ date.format(DateTimeFormatter.ISO_DATE);
    }
}
