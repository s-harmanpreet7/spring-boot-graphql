package in.harmanpreetsingh.springbootgraphql.repository;

import in.harmanpreetsingh.springbootgraphql.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
