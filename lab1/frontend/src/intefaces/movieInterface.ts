export interface ICoordinates {
  x: number;
  y: number;
}

export interface ILocation {
  x: number;
  y: number;
  z: number;
}

export interface IPerson {
  name: string;
  eyeColor: ColorEnum;
  hairColor?: ColorEnum;
  location?: ILocation;
  weight: number;
  nationality: ColorEnum;
}

export enum ColorEnum {
  GREEN = "GREEN",
  RED = "RED",
  WHITE = "WHITE",
  BROWN = "BROWN",
}

export enum CountryEnum {
  GERMANY = "GERMANY",
  THAILAND = "THAILAND",
  SOUTH_KOREA = "SOUTH_KOREA",
  JAPAN = "JAPAN",
}

export enum MpaaRatingEnum {
  G = "G",
  PG = "PG",
  PG_13 = "PG_13",
  R = "R",
}

export enum MovieGenreEnum {
  WESTERN = "WESTERN",
  COMEDY = "COMEDY",
  MUSICAL = "MUSICAL",
  ADVENTURE = "ADVENTURE",
  TRAGEDY = "TRAGEDY",
}

export interface IMovie {
  id: number;
  name: string;
  coordinates: ICoordinates;
  creationDate: string;
  oscarsCount: number;
  budget?: number;
  totalBoxOffice: number;
  mpaaRating?: MpaaRatingEnum;
  director?: IPerson;
  screenwriter: IPerson;
  operator?: IPerson;
  length?: number;
  goldenPalmCount: number;
  usaBoxOffice: number;
  tagline?: string;
  genre: MovieGenreEnum;
}
