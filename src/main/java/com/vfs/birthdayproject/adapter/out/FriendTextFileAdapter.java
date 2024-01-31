package com.vfs.birthdayproject.adapter.out;

import com.vfs.birthdayproject.domain.model.Friend;
import com.vfs.birthdayproject.domain.port.FriendPort;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Component("friendTextFileAdapter") // this is a component outside the domain scope, so we create the bean directly
public class FriendTextFileAdapter implements FriendPort {

    private final ResourceLoader resourceLoader;

    public FriendTextFileAdapter(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public Collection<Friend> getAllFriends() {
        final Resource textDb = resourceLoader.getResource("birthday_text.db");
        try {
            try (final BufferedReader reader = new BufferedReader(new InputStreamReader(textDb.getInputStream()))) {
                return reader.lines()
                        .map(this::buildFriendByLine)
                        .collect(Collectors.toList());
            }
        } catch (IOException e) {
            System.out.println("Was not possible open the database text file");
            return emptyList();
        }
    }

    public Friend buildFriendByLine(String line) {
        String[] values = line.split(",");
        return new Friend(values[0], values[1], values[2], LocalDate.parse(values[3]));
    }

}
