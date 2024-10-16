class UserApiService {
  private API_URL: string;

  constructor() {
    this.API_URL = "http://localhost:8080/backend-1.0-SNAPSHOT/api/v1/user";
  }
}

const userApiService = new UserApiService();
export default userApiService;
