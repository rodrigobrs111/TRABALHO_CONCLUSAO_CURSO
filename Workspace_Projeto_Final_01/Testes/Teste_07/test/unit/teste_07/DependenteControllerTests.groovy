package teste_07



import org.junit.*
import grails.test.mixin.*

@TestFor(DependenteController)
@Mock(Dependente)
class DependenteControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/dependente/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.dependenteInstanceList.size() == 0
        assert model.dependenteInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.dependenteInstance != null
    }

    void testSave() {
        controller.save()

        assert model.dependenteInstance != null
        assert view == '/dependente/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/dependente/show/1'
        assert controller.flash.message != null
        assert Dependente.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/dependente/list'

        populateValidParams(params)
        def dependente = new Dependente(params)

        assert dependente.save() != null

        params.id = dependente.id

        def model = controller.show()

        assert model.dependenteInstance == dependente
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/dependente/list'

        populateValidParams(params)
        def dependente = new Dependente(params)

        assert dependente.save() != null

        params.id = dependente.id

        def model = controller.edit()

        assert model.dependenteInstance == dependente
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/dependente/list'

        response.reset()

        populateValidParams(params)
        def dependente = new Dependente(params)

        assert dependente.save() != null

        // test invalid parameters in update
        params.id = dependente.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/dependente/edit"
        assert model.dependenteInstance != null

        dependente.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/dependente/show/$dependente.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        dependente.clearErrors()

        populateValidParams(params)
        params.id = dependente.id
        params.version = -1
        controller.update()

        assert view == "/dependente/edit"
        assert model.dependenteInstance != null
        assert model.dependenteInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/dependente/list'

        response.reset()

        populateValidParams(params)
        def dependente = new Dependente(params)

        assert dependente.save() != null
        assert Dependente.count() == 1

        params.id = dependente.id

        controller.delete()

        assert Dependente.count() == 0
        assert Dependente.get(dependente.id) == null
        assert response.redirectedUrl == '/dependente/list'
    }
}
