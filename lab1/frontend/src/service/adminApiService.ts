class AdminApiService {
  private API_URL: string;

  constructor() {
    this.API_URL = "http://localhost:8080/backend-1.0-SNAPSHOT/api/v1/admin";
  }
}

const adminApiService = new AdminApiService();
export default adminApiService;
