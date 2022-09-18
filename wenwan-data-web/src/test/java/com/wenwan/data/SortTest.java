package com.wenwan.data;

import com.wenwan.service.api.sort.SortService;
import com.wenwan.service.util.StringDateUtil;
import com.wenwan.web.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SortTest {

    @Autowired
    private SortService sortService;

    @Test
    public void trigger() {
        Integer date = StringDateUtil.getToday();
        sortService.autoTrigger(date);
    }
}
