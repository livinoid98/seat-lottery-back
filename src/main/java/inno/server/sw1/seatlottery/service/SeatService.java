package inno.server.sw1.seatlottery.service;

import inno.server.sw1.seatlottery.mapper.SeatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SeatService {

    private SeatMapper mapper;

    @Autowired
    public SeatService(SeatMapper mapper) {
        this.mapper = mapper;
    }

    public int getCount() {
        return mapper.getCount();
    }

    public int updateChoiceMember(Map<String, Object> payload) {
        return mapper.updateChoiceMember(payload);
    }

    public List<Map<String, Object>> getMemberTable() {
        return mapper.getMemberTable();
    }

    public int resetPolls() {
        return mapper.resetPolls();
    }
}
