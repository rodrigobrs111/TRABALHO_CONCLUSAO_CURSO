package extra



import org.junit.*
import grails.test.mixin.*

/**
 * BuscaControllerTests
 * A unit test class is used to test individual methods or blocks of code without considering the surrounding infrastructure
 */
@TestFor(BuscaController)
@Mock(Busca)
class BuscaControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/busca/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.buscaInstanceList.size() == 0
        assert model.buscaInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.buscaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.buscaInstance != null
        assert view == '/busca/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/busca/show/1'
        assert controller.flash.message != null
        assert Busca.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/busca/list'


        populateValidParams(params)
        def busca = new Busca(params)

        assert busca.save() != null

        params.id = busca.id

        def model = controller.show()

        assert model.buscaInstance == busca
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/busca/list'


        populateValidParams(params)
        def busca = new Busca(params)

        assert busca.save() != null

        params.id = busca.id

        def model = controller.edit()

        assert model.buscaInstance == busca
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/busca/list'

        response.reset()


        populateValidParams(params)
        def busca = new Busca(params)

        assert busca.save() != null

        // test invalid parameters in update
        params.id = busca.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/busca/edit"
        assert model.buscaInstance != null

        busca.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/busca/show/$busca.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        busca.clearErrors()

        populateValidParams(params)
        params.id = busca.id
        params.version = -1
        controller.update()

        assert view == "/busca/edit"
        assert model.buscaInstance != null
        assert model.buscaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/busca/list'

        response.reset()

        populateValidParams(params)
        def busca = new Busca(params)

        assert busca.save() != null
        assert Busca.count() == 1

        params.id = busca.id

        controller.delete()

        assert Busca.count() == 0
        assert Busca.get(busca.id) == null
        assert response.redirectedUrl == '/busca/list'
    }
}
