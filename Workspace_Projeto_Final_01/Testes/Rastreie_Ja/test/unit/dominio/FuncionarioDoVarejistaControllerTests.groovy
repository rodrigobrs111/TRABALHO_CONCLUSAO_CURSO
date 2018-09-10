package dominio



import org.junit.*
import grails.test.mixin.*

/**
 * FuncionarioDoVarejistaControllerTests
 * A unit test class is used to test individual methods or blocks of code without considering the surrounding infrastructure
 */
@TestFor(FuncionarioDoVarejistaController)
@Mock(FuncionarioDoVarejista)
class FuncionarioDoVarejistaControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/funcionarioDoVarejista/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.funcionarioDoVarejistaInstanceList.size() == 0
        assert model.funcionarioDoVarejistaInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.funcionarioDoVarejistaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.funcionarioDoVarejistaInstance != null
        assert view == '/funcionarioDoVarejista/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/funcionarioDoVarejista/show/1'
        assert controller.flash.message != null
        assert FuncionarioDoVarejista.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/funcionarioDoVarejista/list'


        populateValidParams(params)
        def funcionarioDoVarejista = new FuncionarioDoVarejista(params)

        assert funcionarioDoVarejista.save() != null

        params.id = funcionarioDoVarejista.id

        def model = controller.show()

        assert model.funcionarioDoVarejistaInstance == funcionarioDoVarejista
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/funcionarioDoVarejista/list'


        populateValidParams(params)
        def funcionarioDoVarejista = new FuncionarioDoVarejista(params)

        assert funcionarioDoVarejista.save() != null

        params.id = funcionarioDoVarejista.id

        def model = controller.edit()

        assert model.funcionarioDoVarejistaInstance == funcionarioDoVarejista
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/funcionarioDoVarejista/list'

        response.reset()


        populateValidParams(params)
        def funcionarioDoVarejista = new FuncionarioDoVarejista(params)

        assert funcionarioDoVarejista.save() != null

        // test invalid parameters in update
        params.id = funcionarioDoVarejista.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/funcionarioDoVarejista/edit"
        assert model.funcionarioDoVarejistaInstance != null

        funcionarioDoVarejista.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/funcionarioDoVarejista/show/$funcionarioDoVarejista.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        funcionarioDoVarejista.clearErrors()

        populateValidParams(params)
        params.id = funcionarioDoVarejista.id
        params.version = -1
        controller.update()

        assert view == "/funcionarioDoVarejista/edit"
        assert model.funcionarioDoVarejistaInstance != null
        assert model.funcionarioDoVarejistaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/funcionarioDoVarejista/list'

        response.reset()

        populateValidParams(params)
        def funcionarioDoVarejista = new FuncionarioDoVarejista(params)

        assert funcionarioDoVarejista.save() != null
        assert FuncionarioDoVarejista.count() == 1

        params.id = funcionarioDoVarejista.id

        controller.delete()

        assert FuncionarioDoVarejista.count() == 0
        assert FuncionarioDoVarejista.get(funcionarioDoVarejista.id) == null
        assert response.redirectedUrl == '/funcionarioDoVarejista/list'
    }
}
