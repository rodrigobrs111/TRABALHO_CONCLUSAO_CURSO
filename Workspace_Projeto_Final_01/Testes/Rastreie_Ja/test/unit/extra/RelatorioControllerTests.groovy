package extra



import org.junit.*
import grails.test.mixin.*

@TestFor(RelatorioController)
@Mock(Relatorio)
class RelatorioControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/relatorio/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.relatorioInstanceList.size() == 0
        assert model.relatorioInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.relatorioInstance != null
    }

    void testSave() {
        controller.save()

        assert model.relatorioInstance != null
        assert view == '/relatorio/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/relatorio/show/1'
        assert controller.flash.message != null
        assert Relatorio.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/relatorio/list'

        populateValidParams(params)
        def relatorio = new Relatorio(params)

        assert relatorio.save() != null

        params.id = relatorio.id

        def model = controller.show()

        assert model.relatorioInstance == relatorio
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/relatorio/list'

        populateValidParams(params)
        def relatorio = new Relatorio(params)

        assert relatorio.save() != null

        params.id = relatorio.id

        def model = controller.edit()

        assert model.relatorioInstance == relatorio
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/relatorio/list'

        response.reset()

        populateValidParams(params)
        def relatorio = new Relatorio(params)

        assert relatorio.save() != null

        // test invalid parameters in update
        params.id = relatorio.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/relatorio/edit"
        assert model.relatorioInstance != null

        relatorio.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/relatorio/show/$relatorio.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        relatorio.clearErrors()

        populateValidParams(params)
        params.id = relatorio.id
        params.version = -1
        controller.update()

        assert view == "/relatorio/edit"
        assert model.relatorioInstance != null
        assert model.relatorioInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/relatorio/list'

        response.reset()

        populateValidParams(params)
        def relatorio = new Relatorio(params)

        assert relatorio.save() != null
        assert Relatorio.count() == 1

        params.id = relatorio.id

        controller.delete()

        assert Relatorio.count() == 0
        assert Relatorio.get(relatorio.id) == null
        assert response.redirectedUrl == '/relatorio/list'
    }
}
