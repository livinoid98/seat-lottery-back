package inno.server.sw1.seatlottery.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SeatMapper {
    public int getCount();

    public int updateChoiceMember(Map<String, Object> payload);

    public List<Map<String, Object>> getMemberTable();

    public int resetPolls();
}
