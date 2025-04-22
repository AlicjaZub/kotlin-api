DROP SEQUENCE IF EXISTS "city_id_seq";
DROP SEQUENCE IF EXISTS "person_id_seq";
CREATE SEQUENCE "city_id_seq" INCREMENT BY 50 START 1;
CREATE SEQUENCE "person_id_seq" INCREMENT BY 50 START 1;


DROP TABLE IF EXISTS "cities";
CREATE TABLE "cities" (
    "id" bigint NOT NULL,
    "name" VARCHAR(512),
    "country" VARCHAR(512),
    CONSTRAINT "cities_pkey" PRIMARY KEY ("id")
)

DROP TABLE IF EXISTS "persons";
CREATE TABLE "persons" (
    "id" bigint NOT NULL,
    "firstName" VARCHAR(512),
    "lastName" VARCHAR(512),
    "city_id" bigint,
    CONSTRAINT "persons_pkey" PRIMARY KEY ("id")
)
