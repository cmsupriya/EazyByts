// utils.js - plain non-module version
const API_BASE = "http://localhost:8080";

function saveToken(token){ localStorage.setItem('jwt', token); }
function getToken(){ return localStorage.getItem('jwt'); }
function removeToken(){ localStorage.removeItem('jwt'); }

async function apiFetch(path, options = {}) {
  const headers = options.headers || {};
  if (!headers['Content-Type']) headers['Content-Type'] = 'application/json';
  const token = getToken();
  if (token) headers['Authorization'] = 'Bearer ' + token;
  options.headers = headers;
  const res = await fetch(API_BASE + path, options);
  if (!res.ok) {
    const text = await res.text();
    throw new Error(text || `HTTP ${res.status}`);
  }
  return res.status === 204 ? null : res.json();
}
