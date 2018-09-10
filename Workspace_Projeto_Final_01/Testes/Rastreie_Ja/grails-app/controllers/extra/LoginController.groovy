package extra

import org.springframework.dao.DataIntegrityViolationException

class LoginController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [loginInstanceList: Login.list(params), loginInstanceTotal: Login.count()]
    }

    def create() {
        [loginInstance: new Login(params)]
    }

    def save() {
        def loginInstance = new Login(params)
        if (!loginInstance.save(flush: true)) {
            render(view: "create", model: [loginInstance: loginInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'login.label', default: 'Login'), loginInstance.id])
        redirect(action: "show", id: loginInstance.id)
    }

    def show() {
        def loginInstance = Login.get(params.id)
        if (!loginInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'login.label', default: 'Login'), params.id])
            redirect(action: "list")
            return
        }

        [loginInstance: loginInstance]
    }

    def edit() {
        def loginInstance = Login.get(params.id)
        if (!loginInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'login.label', default: 'Login'), params.id])
            redirect(action: "list")
            return
        }

        [loginInstance: loginInstance]
    }

    def update() {
        def loginInstance = Login.get(params.id)
        if (!loginInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'login.label', default: 'Login'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (loginInstance.version > version) {
                loginInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'login.label', default: 'Login')] as Object[],
                          "Another user has updated this Login while you were editing")
                render(view: "edit", model: [loginInstance: loginInstance])
                return
            }
        }

        loginInstance.properties = params

        if (!loginInstance.save(flush: true)) {
            render(view: "edit", model: [loginInstance: loginInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'login.label', default: 'Login'), loginInstance.id])
        redirect(action: "show", id: loginInstance.id)
    }

    def delete() {
        def loginInstance = Login.get(params.id)
        if (!loginInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'login.label', default: 'Login'), params.id])
            redirect(action: "list")
            return
        }

        try {
            loginInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'login.label', default: 'Login'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'login.label', default: 'Login'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
	
	def login()
	{}
	
	
}
