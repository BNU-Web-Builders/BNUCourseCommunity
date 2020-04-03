package com.example.coursecommunity;

import com.hankcs.hanlp.dictionary.stopword.CoreStopWordDictionary;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class AnalysisTests {
    @Test
    void testSegment() {
        /**标准分词**/
        String content = "喜欢这样日系小说，读起来轻松、治愈、没压力，偶尔的下午暖暖斜阳照到窗户上，喝一杯红茶，读这样一本书，就是非常愉悦的一个下午。书中女主角贵子失恋加离职，沉溺在情伤中无法自拔，幸好她的舅舅，一家二手书店的老板拯救了她。在日本东京的一家二手书店里，她通过阅读与亲情走出情伤等一系列的故事。想想每个女生都会有这样的情感阶段，痛苦的失恋，影响工作的正常进行，就想找个地洞好好待着，但朋友家人的温暖与鼓励总能让你走出情伤，继续面对生活。我们像女主一样受伤又愈合，从易脆弱走向百毒不侵，人生总有几个坎节需要自己经历才明白，其实这也没什么大不了的嘛，都会过去的。" +
                "总的说来，《在森崎书店的日子》作为一本治愈系小说，语言浅白、真诚、细腻轻盈，非常容易让人沉迷进去。这本书，虽然缺乏对失恋和死亡深度的探索，但是它所营造的清淡闲适的氛围，就像侯孝贤的电影一样，容易勾起人们对旧时人情美意的怀念。" +
                "看完这本书，爱上了神保町这个地方，感觉一个浪漫主义的地方，又很多未知的故事放生在那个地方，也隐藏着世界上很多人的智慧与情感。而《在森崎书店的日子》就是其中一本。" +
                "最大的感触就是，遇到困难不要只会逃跑，那样还是与以前一样。逃跑虽可耻但有用这样的话，也只是管用一时不能管用一世吧，所以还是要去勇敢面对现实啊！" +
                "看过电影，知道这本书有后续特买来看。译文流畅，文字像电影一样潺潺而流，喜欢里面一句话“但只要拿出勇气，就能拉近彼此的距离”，希望给每一个勇敢的你。" +
                "作为世界最大的二手书店一条街的神保町，有幸去过一次，不过读不懂日文书，误打误撞去的。总觉得这样一条街应该有他自己的故事，没想到看到这本书，和我想的一样文艺与治愈。" +
                "遇到伤心的事，不能自己待着，会越来越丧的。要善于分享，快乐与悲伤，这样给自己减压。疗伤治愈是一件说快也快，说漫长也漫长的事。" +
                "读的时候，觉得自己是如此不清新的一个人，自己的思想已经腐化了。我是如此庸俗的一个人"
                ;
        List<Term> termList = StandardTokenizer.segment(content);
        HashMap<String, Integer> pplHashMap = new HashMap<String, Integer>();
        for (Term term : termList) {
            String[] termSplit = term.toString().split("/");
            if (term.nature.startsWith('m')) continue; // 数词过滤
            if (term.nature.startsWith('q')) continue; // 量词过滤
            //if (term.nature.startsWith('t')) continue; // 时间词过滤
            if (term.nature.startsWith("w")) continue; // 过滤标点符号
            if (CoreStopWordDictionary.contains(term.word)) continue; // 停用词符号
            if (!pplHashMap.containsKey(termSplit[0])) {
                pplHashMap.put(termSplit[0], 1);
            } else {
                int tmp_count = pplHashMap.get(termSplit[0]);
                pplHashMap.put(termSplit[0], tmp_count + 1);
            }

        }
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(pplHashMap.entrySet()); //转换为list
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (Map.Entry<String, Integer> mapping : list){
            System.out.println(mapping.getKey()+": "+mapping.getValue());
        }
    }
}
