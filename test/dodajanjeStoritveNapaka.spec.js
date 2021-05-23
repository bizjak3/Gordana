describe('Dodajanje nove storitve z napako', function () {
    it('Obisk strani za dodajanje in dodajenje', function () {
        cy.visit('http://localhost:4200/login')

        cy.url()
            .should('include', '/login')

        cy.get('.email')
            .type('testko')
            .should('have.value', 'testko')

        cy.get('.password')
            .type('test')
            .should('have.value', 'test')

        cy.get('.btn-primary')
            .click()
        cy.wait(500)

        cy.get('.btn').contains(' Dodaj novo storitev ')
            .click()

        cy.get('h1').contains('Ustvari storitev')

        cy.get('input[name="ime"]')
            .type('Nova storitev')
            .should('have.value', 'Nova storitev')

        cy.get('.od')
            .type(`${new Date().toJSON().toString().substring(0, 10)}`)

        var myDate = new Date(new Date().getTime()+(5*24*60*60*1000));
        myDate = myDate.toJSON().toString().substring(0, 10)
        cy.get('.do')
            .type(myDate)

        cy.get('textarea[name="komentarji"]')
            .type('To je nek komentar.')

        cy.get('textarea[name="omejitve"]')
            .type('To so neke omejitve.')

        cy.get('.btn').contains('Oddaj storitev')
            .click()

        cy.get('.alert')
            .contains(' Lokacija ne sme biti prazna ')
    });
});
