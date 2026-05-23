package org.example.fe_be_team1_be.util;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class QuoteProvider {
    private final List<String> quotes = List.of(
            "나를 죽이지 못하는 것은 나를 더 강하게 만든다. [니체]",
            "방황하는 모든 이들이 길을 잃은 것은 아니다. [톨킨]",
            "어제보다 나은 내일을 만드는 것은 오늘의 나다. [아리스토텔레스]",
            "어디를 가든지 마음을 다해 가라. [공자]",
            "인생은 우리가 만드는 것이다. [버지니아 울프]",
            "실패는 성공을 맛보게 해주는 양념이다. [트루먼 카포티]",
            "끝까지 해보기 전까지는 늘 불가능해 보인다. [넬슨 만델라]",
            "가장 위대한 영광은 한 번도 넘어지지 않는 것이 아니라 넘어질 때마다 일어서는 것이다. [골드스미스]",
            "당신이 할 수 있다고 믿든 할 수 없다고 믿든, 당신이 옳다. [헨리 포드]",
            "우리는 생각하는 대로 된다. [얼 나이팅게일]"
    );
    public String getRandomQuote() {
        Random random = new Random();
        int index = ThreadLocalRandom.current().nextInt(quotes.size());

        return quotes.get(index);
    }
}
