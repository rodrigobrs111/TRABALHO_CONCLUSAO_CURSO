package teste_11



import org.junit.*
import grails.test.mixin.*

@TestFor(DonoController)
@Mock(Dono)
class DonoControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/dono/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.donoInstanceList.size() == 0
        assert model.donoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.donoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.donoInstance != null
        assert view == '/dono/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/dono/show/1'
        assert controller.flash.message != null
        assert Dono.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/dono/list'

        populateValidParams(params)
        def dono = new Dono(params)

        assert dono.save() != null

        params.id = dono.id

        def model = controller.show()

        assert model.donoInstance == dono
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/dono/list'

        populateValidParams(params)
        def dono = new Dono(params)

        assert dono.save() != null

        params.id = dono.id

        def model = controller.edit()

        assert model.donoInstance == dono
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/dono/list'

        response.reset()

        populateValidParams(params)
        def dono = new Dono(params)

        assert dono.save() != null

        // test invalid parameters in update
        params.id = dono.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/dono/edit"
        assert model.donoInstance != null

        dono.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/dono/show/$dono.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        dono.clearErrors()

        populateValidParams(params)
        params.id = dono.id
        params.version = -1
        controller.update()

        assert view == "/dono/edit"
        assert model.donoInstance != null
        assert model.donoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/dono/list'

        response.reset()

        populateValidParams(params)
        def dono = new Dono(params)

        assert dono.save() != null
        assert Dono.count() == 1

        params.id = dono.id

        controller.delete()

        assert Dono.count() == 0
        assert Dono.get(dono.id) == null
        assert response.redirectedUrl == '/dono/list'
    }
}
