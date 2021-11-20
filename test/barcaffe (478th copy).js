// barcaffe.js created with Cypress
//
// Start writing your Cypress tests below!
// If you're unfamiliar with how Cypress works,
// check out the link below and learn how to write your first test:
// https://on.cypress.io/writing-first-test
describe('Dodajanje novega psa', function () {
    it('Obisk strani za dodajanje in dodajenje', function () {
        cy.visit('https://www.barcaffe.si/play/start')

        cy.get('input[name="email"]')
            .type('gostisce@primarjotu.si')
            .should('have.value', 'gostisce@primarjotu.si')

        cy.get('input[name="password"]')
            .type('JjugpEkmcyV3SW4')
            .should('have.value', 'JjugpEkmcyV3SW4')

        cy.get('input[name="log_in"]')
            .click()
        cy.wait(500)

        

        cy.get('.sh-button--primary').contains('IGRAJ')
        .click()

        cy.wait(1000)

        cy.get('.sh-button--primary').contains('DODAJ KAVO')
            .click()

        cy.wait(7000)
            
        cy.get('.sh-button--primary').contains('DODAJ VRELO VODO')
            .click()

        cy.wait(1000)

        cy.get('.sh-button--primary').contains('PREMEŠAJ')
            .click()

        cy.wait(1000)

        cy.get('.sh-button--primary').contains('PREMEŠAJ PREMEŠAJ')
            .click()

        cy.wait(500)

        cy.get('.sh-button--primary').contains('PREMEŠAJ PREMEŠAJ')
            .click()

        cy.wait(8000)

        cy.get('.sh-button--primary').contains('IGRAJ PONOVNO')
            .click()
        
        
        cy.wait(6000)

    });
});
