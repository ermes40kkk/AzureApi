package mossino.azure.apiAzure.repository;

import jakarta.annotation.PostConstruct;
import mossino.azure.apiAzure.model.Bill;
import mossino.azure.apiAzure.model.Status;
import mossino.azure.apiAzure.model.Type;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BillCollectionRepository {
    private  final List<Bill> billList = new ArrayList<>();

    public BillCollectionRepository(){

    }
    public List<Bill> finAll() {
        return billList;
    }
    public Optional<Bill> findById(Integer id){
        return billList.stream().filter(c -> c.id().equals(id)).findFirst();
    }
    @PostConstruct
    private void init() {
        billList.add(new Bill(111, "title1", "des1", Status.PUBLIC, Type.BILL, LocalDateTime.now(),null ,1000));
        billList.add(new Bill(2, "title2", "des2", Status.PUBLIC, Type.CREDIT_NOTE, LocalDateTime.now(),null ,2000));
        billList.add(new Bill(3, "title3", "des3", Status.PUBLIC, Type.BILL, LocalDateTime.now(),null ,1300));
        billList.add(new Bill(4, "title4", "des4", Status.PUBLIC, Type.BILL, LocalDateTime.now(),null ,1040));
        billList.add(new Bill(5, "title5", "des5", Status.PUBLIC, Type.BILL, LocalDateTime.now(),null ,5000));
        billList.add(new Bill(6, "title6", "des6", Status.PUBLIC, Type.CREDIT_NOTE, LocalDateTime.now(),null ,4000));
        billList.add(new Bill(7, "title7", "des7", Status.PUBLIC, Type.BILL, LocalDateTime.now(),null ,1900));
        billList.add(new Bill(8, "title8", "des8", Status.PUBLIC, Type.FISCAL_NOTE, LocalDateTime.now(),null ,1220));
        billList.add(new Bill(9, "title9", "des9", Status.PUBLIC, Type.BILL, LocalDateTime.now(),null ,300));
        billList.add(new Bill(10, "title10", "des10", Status.PUBLIC, Type.BILL, LocalDateTime.now(),null ,40));
        billList.add(new Bill(11, "title11", "des11", Status.PUBLIC, Type.CREDIT_NOTE, LocalDateTime.now(),null ,100));
        billList.add(new Bill(12, "title12", "des12", Status.PUBLIC, Type.BILL, LocalDateTime.now(),null ,99990));
        billList.add(new Bill(13, "title13", "des13", Status.PUBLIC, Type.FISCAL_NOTE, LocalDateTime.now(),null ,500));
        billList.add(new Bill(14, "title14", "des14", Status.PUBLIC, Type.BILL, LocalDateTime.now(),null ,1660));
        billList.add(new Bill(15, "title15", "des15", Status.PUBLIC, Type.BILL, LocalDateTime.now(),null ,20));
    }

    public void save(Bill bill) {
        this.billList.removeIf(c -> c.id().equals(bill.id()));
        this.billList.add(bill);
    }

    public boolean existsById(Integer id) {
        return billList.stream().anyMatch(c -> c.id().equals(id));
    }

    public void deleteById(Integer id) {
        billList.removeIf(c -> c.id().equals(id));
    }
}
