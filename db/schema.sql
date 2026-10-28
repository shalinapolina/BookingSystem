PRAGMA foreign_keys = ON;

CREATE TABLE IF NOT EXISTS hotels (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    title       TEXT NOT NULL,
    description TEXT
);

CREATE TABLE IF NOT EXISTS rooms (
    id              INTEGER PRIMARY KEY AUTOINCREMENT,
    hotel_id        INTEGER NOT NULL,
    type            TEXT NOT NULL CHECK (type IN ('STANDARD', 'DELUXE', 'SUITE')),
    capacity        INTEGER NOT NULL CHECK (capacity > 0),
    price_per_night INTEGER NOT NULL CHECK (price_per_night > 0),
    description     TEXT,
    is_enabled      INTEGER NOT NULL DEFAULT 1 CHECK (is_enabled IN (0, 1)),
    FOREIGN KEY (hotel_id) REFERENCES hotels(id)
);