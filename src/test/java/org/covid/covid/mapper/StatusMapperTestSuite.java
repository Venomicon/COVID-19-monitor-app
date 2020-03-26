package org.covid.covid.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatusMapperTestSuite {
    @Autowired
    StatusMapper statusMapper;

    @Test
    public void testMappingToStatus() {
        String jsonResponse = "[[{\"confirmed\":\"975683\",\"recovered\":\"235187\",\"deaths\":\"44083\"}]]";

        System.out.println(statusMapper.mapToStatus(jsonResponse));

    }
}
