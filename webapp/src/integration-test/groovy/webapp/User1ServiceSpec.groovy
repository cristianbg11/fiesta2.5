package webapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class User1ServiceSpec extends Specification {

    User1Service user1Service
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new User1(...).save(flush: true, failOnError: true)
        //new User1(...).save(flush: true, failOnError: true)
        //User1 user1 = new User1(...).save(flush: true, failOnError: true)
        //new User1(...).save(flush: true, failOnError: true)
        //new User1(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //user1.id
    }

    void "test get"() {
        setupData()

        expect:
        user1Service.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<User1> user1List = user1Service.list(max: 2, offset: 2)

        then:
        user1List.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        user1Service.count() == 5
    }

    void "test delete"() {
        Long user1Id = setupData()

        expect:
        user1Service.count() == 5

        when:
        user1Service.delete(user1Id)
        sessionFactory.currentSession.flush()

        then:
        user1Service.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        User1 user1 = new User1()
        user1Service.save(user1)

        then:
        user1.id != null
    }
}
