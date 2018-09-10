package extra



import org.junit.*
import grails.test.mixin.*

/**
 * CadastroControllerTests
 * A unit test class is used to test individual methods or blocks of code without considering the surrounding infrastructure
 */
@TestFor(CadastroController)
@Mock(Cadastro)
class CadastroControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/cadastro/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.cadastroInstanceList.size() == 0
        assert model.cadastroInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.cadastroInstance != null
    }

    void testSave() {
        controller.save()

        assert model.cadastroInstance != null
        assert view == '/cadastro/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/cadastro/show/1'
        assert controller.flash.message != null
        assert Cadastro.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/cadastro/list'


        populateValidParams(params)
        def cadastro = new Cadastro(params)

        assert cadastro.save() != null

        params.id = cadastro.id

        def model = controller.show()

        assert model.cadastroInstance == cadastro
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/cadastro/list'


        populateValidParams(params)
        def cadastro = new Cadastro(params)

        assert cadastro.save() != null

        params.id = cadastro.id

        def model = controller.edit()

        assert model.cadastroInstance == cadastro
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/cadastro/list'

        response.reset()


        populateValidParams(params)
        def cadastro = new Cadastro(params)

        assert cadastro.save() != null

        // test invalid parameters in update
        params.id = cadastro.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/cadastro/edit"
        assert model.cadastroInstance != null

        cadastro.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/cadastro/show/$cadastro.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        cadastro.clearErrors()

        populateValidParams(params)
        params.id = cadastro.id
        params.version = -1
        controller.update()

        assert view == "/cadastro/edit"
        assert model.cadastroInstance != null
        assert model.cadastroInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/cadastro/list'

        response.reset()

        populateValidParams(params)
        def cadastro = new Cadastro(params)

        assert cadastro.save() != null
        assert Cadastro.count() == 1

        params.id = cadastro.id

        controller.delete()

        assert Cadastro.count() == 0
        assert Cadastro.get(cadastro.id) == null
        assert response.redirectedUrl == '/cadastro/list'
    }
}
