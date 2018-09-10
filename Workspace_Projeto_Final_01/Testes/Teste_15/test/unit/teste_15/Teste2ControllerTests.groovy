package teste_15



import org.junit.*
import grails.test.mixin.*

@TestFor(Teste2Controller)
@Mock(Teste2)
class Teste2ControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/teste2/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.teste2InstanceList.size() == 0
        assert model.teste2InstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.teste2Instance != null
    }

    void testSave() {
        controller.save()

        assert model.teste2Instance != null
        assert view == '/teste2/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/teste2/show/1'
        assert controller.flash.message != null
        assert Teste2.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/teste2/list'

        populateValidParams(params)
        def teste2 = new Teste2(params)

        assert teste2.save() != null

        params.id = teste2.id

        def model = controller.show()

        assert model.teste2Instance == teste2
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/teste2/list'

        populateValidParams(params)
        def teste2 = new Teste2(params)

        assert teste2.save() != null

        params.id = teste2.id

        def model = controller.edit()

        assert model.teste2Instance == teste2
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/teste2/list'

        response.reset()

        populateValidParams(params)
        def teste2 = new Teste2(params)

        assert teste2.save() != null

        // test invalid parameters in update
        params.id = teste2.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/teste2/edit"
        assert model.teste2Instance != null

        teste2.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/teste2/show/$teste2.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        teste2.clearErrors()

        populateValidParams(params)
        params.id = teste2.id
        params.version = -1
        controller.update()

        assert view == "/teste2/edit"
        assert model.teste2Instance != null
        assert model.teste2Instance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/teste2/list'

        response.reset()

        populateValidParams(params)
        def teste2 = new Teste2(params)

        assert teste2.save() != null
        assert Teste2.count() == 1

        params.id = teste2.id

        controller.delete()

        assert Teste2.count() == 0
        assert Teste2.get(teste2.id) == null
        assert response.redirectedUrl == '/teste2/list'
    }
}
