import axios, { AxiosResponse } from "axios";
import { IMovie } from "../intefaces/movieInterface"; // Импортируйте ваши интерфейсы

class MovieApiService {
  private API_URL: string;

  constructor() {
    this.API_URL = "http://localhost:8080/backend-1.0-SNAPSHOT/api/v1/movie";
  }

  // Создание нового фильма
  async createMovie(movie: IMovie): Promise<IMovie> {
    const response: AxiosResponse<IMovie> = await axios.post(
      this.API_URL,
      movie
    );
    return response.data;
  }

  // Получение фильма по ID
  async getMovieById(id: number): Promise<IMovie> {
    const response: AxiosResponse<IMovie> = await axios.get(
      `${this.API_URL}/${id}`
    );
    return response.data;
  }

  // Получение всех фильмов
  async getAllMovies(): Promise<IMovie[]> {
    const response: AxiosResponse<IMovie[]> = await axios.get(
      `${this.API_URL}/all`
    );
    return response.data;
  }

  // Обновление фильма по ID
  async updateMovie(id: number, movie: Partial<IMovie>): Promise<IMovie> {
    const response: AxiosResponse<IMovie> = await axios.put(
      `${this.API_URL}/${id}`,
      movie
    );
    return response.data;
  }

  // Удаление фильма по ID
  async deleteMovie(id: number): Promise<void> {
    await axios.delete(`${this.API_URL}/${id}`);
  }
}

// Экспортируйте экземпляр класса
const movieApiService = new MovieApiService();
export default movieApiService;
