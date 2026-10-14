const API_BASE = import.meta.env.VITE_API_BASE || 'http://localhost:8080/api';

export async function apiList(resource) {
  const response = await fetch(`${API_BASE}/${resource}`);
  if (!response.ok) throw new Error(`Could not load ${resource} (${response.status})`);
  return response.json();
}
export async function apiCreate(resource, payload) {
  const response = await fetch(`${API_BASE}/${resource}`, {
    method:'POST', headers:{'Content-Type':'application/json'}, body:JSON.stringify(payload)
  });
  const body = await response.json().catch(()=>({}));
  if (!response.ok) throw new Error(body.message || `Could not create record (${response.status})`);
  return body;
}
export async function apiUpdate(resource, id, payload) {
  const response = await fetch(`${API_BASE}/${resource}/${id}`, {
    method:'PUT', headers:{'Content-Type':'application/json'}, body:JSON.stringify(payload)
  });
  const body = await response.json().catch(()=>({}));
  if (!response.ok) throw new Error(body.message || `Could not update record (${response.status})`);
  return body;
}
export async function apiDelete(resource, id) {
  const response = await fetch(`${API_BASE}/${resource}/${id}`, {method:'DELETE'});
  if (!response.ok) throw new Error(`Could not delete record (${response.status})`);
}
export async function apiHealth() {
  const response = await fetch(`${API_BASE}/health`);
  if (!response.ok) throw new Error('Backend is unavailable');
  return response.json();
}