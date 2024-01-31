package com.vfs.birthdayproject;

import com.vfs.birthdayproject.adapter.in.util.LocalDateMapper;
import com.vfs.birthdayproject.adapter.out.EmailNotificationAdapter;
import com.vfs.birthdayproject.adapter.out.FriendSqliteAdapter;
import com.vfs.birthdayproject.infrastructure.configuration.DomainBeanConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;

@TestConfiguration
@Import({DomainBeanConfiguration.class, FriendSqliteAdapter.class, EmailNotificationAdapter.class, LocalDateMapper.class})
public class BeanTestConfiguration {
}
