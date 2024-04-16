package inno.server.sw1.seatlottery.controller;

import inno.server.sw1.seatlottery.service.SeatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("api/seat")
@CrossOrigin(origins = "*")
@ResponseBody
@Slf4j
public class SeatController {

    private SeatService service;

    @Autowired
    public SeatController(SeatService service) {
        this.service = service;
    }

    @GetMapping("/count")
    public int getCount() {
        return service.getCount();
    }

    @PostMapping("/choice")
    public int updateChoiceMember(@RequestBody Map<String, Object> payload) {
        return service.updateChoiceMember(payload);
    }

    @GetMapping("/shuffle")
    public String[] shuffleSeat() {

        String[] members = {"김예지","김원건","김은혜","김현범","박병윤","박상직","박수향","배용호","신용환","신윤정","신은욱","유성재","이혜정","장정호","최예진","최찬영"};

        List<Map<String, Object>> memberTable = service.getMemberTable();
        Map<String, Object> memberMap = new HashMap<>();
        String[] result = new String[members.length];
        int max = 0;

        int size = memberTable.size();
        for(int i=0; i<size; i++) {
            memberMap.put(memberTable.get(i).get("member").toString(), memberTable.get(i).get("choice").toString());
        }

        for(int i=0; i<50; i++) {
            List<String> temp = Arrays.asList(members);
            Collections.shuffle(temp);
            temp.toArray(members);

            int count = 0;
            int length = members.length;
            for(int j=0; j<length; j++) {
                if(j-1 >= 0 && memberMap.get(members[j]) == members[j-1]) {
                    count++;
                }

                if(j+1 < length && memberMap.get(members[j]) == members[j+1]) {
                    count++;
                }
            }

            if(count >= max) {
                result = Arrays.copyOf(members, members.length);
            }
        }
        return result;
    }

    @GetMapping("/reset")
    public int resetPolls() {
        return service.resetPolls();
    }

}
