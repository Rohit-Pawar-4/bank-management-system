# StateBank Full-Stack Banking Management Demo

A local development project containing:
- React + Vite frontend
- Java 21 + Spring Boot REST API
- Spring Data JPA / Hibernate
- MySQL database
- CRUD for customers, accounts, transactions, cards, loans, branches, employees and reports

**Important:** This is an educational demo with fictional seed data. It is not connected to SBI or any real bank, does not implement production-grade banking security, and must not be used to move real money. Real banking systems need professional security, authorization, audit logging, transaction controls, regulatory checks and security review.

## Prerequisites
1. Node.js 20+ and npm
2. Java JDK 21
3. MySQL Server 8+
4. Maven (or use your IDE's Maven support)

## 1. Create the database
Open MySQL Workbench and run:

```sql
CREATE DATABASE IF NOT EXISTS statebank_demo
  CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

## 2. Configure backend database credentials
Open `backend/src/main/resources/application.properties` and set your MySQL username/password, or provide environment variables:

- `DB_URL` (default `jdbc:mysql://localhost:3306/statebank_demo?createDatabaseIfNotExist=true`)
- `DB_USERNAME` (default `root`)
- `DB_PASSWORD` (default empty)

## 3. Start backend
Open a terminal in `backend`:

```bash
mvn spring-boot:run
```

Backend URL: `http://localhost:8080`
Health check: `http://localhost:8080/api/health`

On startup, Hibernate creates/updates tables for the entity classes. The app seeds fictional demo records if the tables are empty.

## 4. Start frontend
Open another terminal in `frontend`:

```bash
npm install
npm run dev
```

Open the Vite URL, usually `http://localhost:5173`.

## API endpoints
All endpoints use JSON:
- `GET /api/customers`, `POST /api/customers`, `GET/PUT/DELETE /api/customers/{id}`
- `GET /api/accounts`, `POST /api/accounts`, `GET/PUT/DELETE /api/accounts/{id}`
- `GET /api/transactions`, `POST /api/transactions`, `GET/PUT/DELETE /api/transactions/{id}`
- `GET /api/cards`, `POST /api/cards`, `GET/PUT/DELETE /api/cards/{id}`
- `GET /api/loans`, `POST /api/loans`, `GET/PUT/DELETE /api/loans/{id}`
- `GET /api/branches`, `POST /api/branches`, `GET/PUT/DELETE /api/branches/{id}`
- `GET /api/employees`, `POST /api/employees`, `GET/PUT/DELETE /api/employees/{id}`
- `GET /api/reports`, `POST /api/reports`, `GET/PUT/DELETE /api/reports/{id}`

## Notes for your backend teammate
This is a working foundational schema, not the complete 45-entity ERD implementation yet. It includes the eight main operational modules and simple foreign-key IDs where appropriate. To match the supplied diagram exactly, expand the schema with role/user management, addresses, contacts, KYC, identity proof, nominee, customer documents/profile, departments, employee roles/contacts/addresses, joint accounts, account holders/nominees, transaction types/statuses, deposits, withdrawals, fund transfers, beneficiaries, payments, digital banking, loan types, interest rates and loan payments.
