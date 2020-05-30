package backend.repository;

import backend.model.DailyStatus;
import backend.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface DailyStatusRepository extends JpaRepository<DailyStatus, Long> {

        DailyStatus findById(long id);
        List<DailyStatus> findByUserId(long id);
        List<DailyStatus> findAll();

        DailyStatus save(DailyStatus dailyStatus);

        @Modifying
        void deleteById(long id);
}
