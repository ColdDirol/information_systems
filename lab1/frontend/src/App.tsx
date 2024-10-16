import { Content, Container } from "rsuite";
import "rsuite/dist/rsuite.min.css";
import HeaderComponent from "./components/header/HeaderComponent";
import TableComponent from "./components/table/TableComponent";

export default function App() {
  return (
    <>
      <div className="show-container">
        <Container>
          <HeaderComponent />

          <Content>
            <TableComponent />
          </Content>
        </Container>
      </div>
    </>
  );
}
