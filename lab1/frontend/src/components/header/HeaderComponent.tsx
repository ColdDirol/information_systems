import { FC, useState } from "react";
import { Header, Nav, Navbar } from "rsuite";
import LoginComponent from "../auth/LoginComponent";
import RegisterComponent from "../auth/RegisterComponent";

interface CustomNavbarProps {
  onSelect: (eventKey: string | number) => void; // Указываем тип для функции onSelect
  activeKey: string | number | null; // Указываем тип для activeKey
  [key: string]: any; // Позволяем передавать другие пропсы
}

const CustomNavbar: FC<CustomNavbarProps> = ({
  onSelect,
  activeKey,
  ...props
}) => {
  return (
    <Navbar {...props}>
      <Navbar.Brand href="#">MOVIE CRUD</Navbar.Brand>
      <Nav onSelect={onSelect} activeKey={activeKey}>
        <Nav.Item eventKey="1">Home</Nav.Item>
        <Nav.Item eventKey="2">Events</Nav.Item>
        <Nav.Item eventKey="3">Movies</Nav.Item>
      </Nav>
      <Nav pullRight>
        <RegisterComponent />
        <LoginComponent />
      </Nav>
    </Navbar>
  );
};

export default function HeaderComponent() {
  const [activeKey, setActiveKey] = useState<string | number | null>(null);

  const handleSelect = (eventKey: string | number) => {
    console.log("active:", eventKey);
    setActiveKey(eventKey);
  };

  return (
    <>
      <Header>
        <CustomNavbar activeKey={activeKey} onSelect={handleSelect} />
      </Header>
    </>
  );
}
