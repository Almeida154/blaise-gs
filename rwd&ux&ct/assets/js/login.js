const user = 'rafaelmr';
const password = '123';

function login() {
  const userInserted = prompt('Insira seu user');
  const passwordInserted = prompt('Insira a senha');

  if (userInserted === user && password == passwordInserted) {
    alert('Você já é cadastrado!');
  }
}
