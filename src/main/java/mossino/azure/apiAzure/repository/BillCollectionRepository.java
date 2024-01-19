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
        billList.add(new Bill(1, "ALPINE", "1023RG001", Status.PUBLIC, Type.BILL, LocalDateTime.now(),null ,1000));
        billList.add(new Bill(2, "OMEN", "1023RG002", Status.PUBLIC, Type.CREDIT_NOTE, LocalDateTime.now(),null ,2000));
        billList.add(new Bill(3, "ALPINE", "1023RG003", Status.PUBLIC, Type.BILL, LocalDateTime.now(),null ,1300));
        billList.add(new Bill(4, "MARK", "1023RG004", Status.PUBLIC, Type.BILL, LocalDateTime.now(),null ,1040));
        billList.add(new Bill(5, "ALPINE", "1023RG005", Status.PUBLIC, Type.BILL, LocalDateTime.now(),null ,5000));
        billList.add(new Bill(6, "ALPINEXXXXX", "1023RG006", Status.PUBLIC, Type.CREDIT_NOTE, LocalDateTime.now(),null ,4000));
        billList.add(new Bill(7, "ALPINEXXXXX", "1023RG007", Status.PUBLIC, Type.BILL, LocalDateTime.now(),null ,1900));
        billList.add(new Bill(8, "ALPINE", "1023FI001", Status.PUBLIC, Type.FISCAL_NOTE, LocalDateTime.now(),null ,1220));
        billList.add(new Bill(9, "SDA", "1023RG009", Status.PUBLIC, Type.BILL, LocalDateTime.now(),null ,300));
        billList.add(new Bill(10, "DHL", "1024RG001", Status.PUBLIC, Type.BILL, LocalDateTime.now(),null ,40));
        billList.add(new Bill(11, "ALPINE", "1024GU001", Status.PUBLIC, Type.CREDIT_NOTE, LocalDateTime.now(),null ,100));
        billList.add(new Bill(12, "ALPINE", "1024RG003", Status.PUBLIC, Type.BILL, LocalDateTime.now(),null ,99990));
        billList.add(new Bill(13, "DHL", "1024GU004", Status.PUBLIC, Type.FISCAL_NOTE, LocalDateTime.now(),null ,500));
        billList.add(new Bill(14, "ALPINE", "1024RG005", Status.PUBLIC, Type.BILL, LocalDateTime.now(),null ,1660));
        billList.add(new Bill(15, "ALPINE", "1024RG006", Status.PUBLIC, Type.BILL, LocalDateTime.now(),null ,20));
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
