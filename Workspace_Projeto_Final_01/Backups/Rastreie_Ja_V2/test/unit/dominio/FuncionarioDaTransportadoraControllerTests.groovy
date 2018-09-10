package dominio



import org.junit.*
import grails.test.mixin.*

/**
 * FuncionarioDaTransportadoraControllerTests
 * A unit test class is used to test individual methods or blocks of code without considering the surrounding infrastructure
 */
@TestFor(FuncionarioDaTransportadoraController)
@Mock(FuncionarioDaTransportadora)
class FuncionarioDaTransportadoraControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/funcionarioDaTransportadora/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.funcionarioDaTransportadoraInstanceList.size() == 0
        assert model.funcionarioDaTransportadoraInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.funcionarioDaTransportadoraInstance != null
    }

    void testSave() {
        controller.save()

        assert model.funcionarioDaTransportadoraInstance != null
        assert view == '/funcionarioDaTransportadora/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/funcionarioDaTransportadora/show/1'
        assert controller.flash.message != null
        assert FuncionarioDaTransportadora.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/funcionarioDaTransportadora/list'


        populateValidParams(params)
        def funcionarioDaTransportadora = new FuncionarioDaTransportadora(params)

        assert funcionarioDaTransportadora.save() != null

        params.id = funcionarioDaTransportadora.id

        def model = controller.show()

        assert model.funcionarioDaTransportadoraInstance == funcionarioDaTransportadora
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/funcionarioDaTransportadora/list'


        populateValidParams(params)
        def funcionarioDaTransportadora = new FuncionarioDaTransportadora(params)

        assert funcionarioDaTransportadora.save() != null

        params.id = funcionarioDaTransportadora.id

        def model = controller.edit()

        assert model.funcionarioDaTransportadoraInstance == funcionarioDaTransportadora
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/funcionarioDaTransportadora/list'

        response.reset()


        populateValidParams(params)
        def funcionarioDaTransportadora = new FuncionarioDaTransportadora(params)

        assert funcionarioDaTransportadora.save() != null

        // test invalid parameters in update
        params.id = funcionarioDaTransportadora.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/funcionarioDaTransportadora/edit"
        assert model.funcionarioDaTransportadoraInstance != null

        funcionarioDaTransportadora.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/funcionarioDaTransportadora/show/$funcionarioDaTransportadora.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        funcionarioDaTransportadora.clearErrors()

        populateValidParams(params)
        params.id = funcionarioDaTransportadora.id
        params.version = -1
        controller.update()

        assert view == "/funcionarioDaTransportadora/edit"
        assert model.funcionarioDaTransportadoraInstance != null
        assert model.funcionarioDaTransportadoraInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/funcionarioDaTransportadora/list'

        response.reset()

        populateValidParams(params)
        def funcionarioDaTransportadora = new FuncionarioDaTransportadora(params)

        assert funcionarioDaTransportadora.save() != null
        assert FuncionarioDaTransportadora.count() == 1

        params.id = funcionarioDaTransportadora.id

        controller.delete()

        assert FuncionarioDaTransportadora.count() == 0
        assert FuncionarioDaTransportadora.get(funcionarioDaTransportadora.id) == null
        assert response.redirectedUrl == '/funcionarioDaTransportadora/list'
    }
}
