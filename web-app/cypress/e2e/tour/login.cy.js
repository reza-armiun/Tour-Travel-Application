


describe('login example', () => {

  beforeEach(() => {
    cy.visit('http://localhost:4200/signin')
  })

  it('should display 1 login form', () => {
    cy.get('form').should('have.length', 1);
  })
  it('should display 1 username field and 1 password field' ,() => {

    cy.get('form').find('[type="text"]').
    should('have.length', 1);
    cy.get('form').find('[type="password"]').
    should('have.length', 1);
  })
  it('should display 1 submit button' ,() => {
    cy.get('form').find('[type="submit"]').
    should('have.length', 1);
  })

  it('should login and redirect to home page' , () => {
    cy.get('form').find('[type="text"]').
    type('reza');
    cy.get('form').find('[type="password"]').
    type('12345678');
    cy.get('form').find('[type="submit"]').click();

    cy.url().should('eq', 'http://localhost:4200/');
  });

});
