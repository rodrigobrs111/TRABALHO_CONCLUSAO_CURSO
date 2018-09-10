package dominio



import org.junit.*
import grails.test.mixin.*

/**
 * SupervisorDoVarejistaControllerTests
 * A unit test class is used to test individual methods or blocks of code without considering the surrounding infrastructure
 */
@TestFor(SupervisorDoVarejistaController)
@Mock(SupervisorDoVarejista)
class SupervisorDoVarejistaControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/supervisorDoVarejista/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.supervisorDoVarejistaInstanceList.size() == 0
        assert model.supervisorDoVarejistaInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.supervisorDoVarejistaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.supervisorDoVarejistaInstance != null
        assert view == '/supervisorDoVarejista/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/supervisorDoVarejista/show/1'
        assert controller.flash.message != null
        assert SupervisorDoVarejista.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/supervisorDoVarejista/list'


        populateValidParams(params)
        def supervisorDoVarejista = new SupervisorDoVarejista(params)

        assert supervisorDoVarejista.save() != null

        params.id = supervisorDoVarejista.id

        def model = controller.show()

        assert model.supervisorDoVarejistaInstance == supervisorDoVarejista
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/supervisorDoVarejista/list'


        populateValidParams(params)
        def supervisorDoVarejista = new SupervisorDoVarejista(params)

        assert supervisorDoVarejista.save() != null

        params.id = supervisorDoVarejista.id

        def model = controller.edit()

        assert model.supervisorDoVarejistaInstance == supervisorDoVarejista
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/supervisorDoVarejista/list'

        response.reset()


        populateValidParams(params)
        def supervisorDoVarejista = new SupervisorDoVarejista(params)

        assert supervisorDoVarejista.save() != null

        // test invalid parameters in update
        params.id = supervisorDoVarejista.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/supervisorDoVarejista/edit"
        assert model.supervisorDoVarejistaInstance != null

        supervisorDoVarejista.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/supervisorDoVarejista/show/$supervisorDoVarejista.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        supervisorDoVarejista.clearErrors()

        populateValidParams(params)
        params.id = supervisorDoVarejista.id
        params.version = -1
        controller.update()

        assert view == "/supervisorDoVarejista/edit"
        assert model.supervisorDoVarejistaInstance != null
        assert model.supervisorDoVarejistaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/supervisorDoVarejista/list'

        response.reset()

        populateValidParams(params)
        def supervisorDoVarejista = new SupervisorDoVarejista(params)

        assert supervisorDoVarejista.save() != null
        assert SupervisorDoVarejista.count() == 1

        params.id = supervisorDoVarejista.id

        controller.delete()

        assert SupervisorDoVarejista.count() == 0
        assert SupervisorDoVarejista.get(supervisorDoVarejista.id) == null
        assert response.redirectedUrl == '/supervisorDoVarejista/list'
    }
}
