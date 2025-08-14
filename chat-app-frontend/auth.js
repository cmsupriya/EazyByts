// auth.js
document.getElementById('loginForm').addEventListener('submit', async (e) => {
  e.preventDefault();
  const username = document.getElementById('loginUsername').value.trim();
  const password = document.getElementById('loginPassword').value;
  try {
    const res = await apiFetch('/api/auth/login', { method: 'POST', body: JSON.stringify({ username, password }) });
    saveToken(res.token);
    window.location = 'chat.html'; // changed from /chat.html to relative
  } catch (err) {
    document.getElementById('authMsg').textContent = err.message;
  }
});

document.getElementById('registerForm').addEventListener('submit', async (e) => {
  e.preventDefault();
  const username = document.getElementById('regUsername').value.trim();
  const password = document.getElementById('regPassword').value;
  try {
    const res = await apiFetch('/api/auth/register', { method: 'POST', body: JSON.stringify({ username, password }) });
    saveToken(res.token);
    window.location = 'chat.html'; // changed from /chat.html to relative
  } catch (err) {
    document.getElementById('authMsg').textContent = err.message;
  }
});

// redirect if token present
if (getToken() && (location.pathname.endsWith('/') || location.pathname.endsWith('index.html'))) {
  location = 'chat.html'; // changed from /chat.html
}
