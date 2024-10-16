import { CSSProperties, useEffect, useState } from "react";
import { Placeholder, Table } from "rsuite";
import { Cell, HeaderCell } from "rsuite-table";
import Column from "rsuite/esm/Table/TableColumn";
import { IMovie } from "../../intefaces/movieInterface";
import movieApiService from "../../service/movieApiService";

const columns = [
  {
    key: "id",
    label: "id",
    flexGrow: 1,
  },
  {
    key: "name",
    label: "Name",
    flexGrow: 2,
  },
];

const loaderContainerStyle: CSSProperties = {
  position: "absolute" as "absolute", // Указываем конкретное значение
  width: "100%",
  height: "100%",
  background: "var(--rs-bg-card)",
  padding: 20,
  zIndex: 1,
};

export default function TableComponent() {
  const [data, setData] = useState<IMovie[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const movies = await movieApiService.getAllMovies();
        setData(movies);
      } catch (error) {
        console.error("Error fetching movies:", error);
      } finally {
        setLoading(false);
      }
    };

    fetchData();
  }, []);

  const renderLoading = () => {
    return (
      <div style={loaderContainerStyle}>
        <Placeholder.Grid rows={9} columns={4} active />
      </div>
    );
  };

  const handleClick = (rowData: any) => {
    console.log("Clicked on row:", rowData);
  };

  return (
    <div>
      <hr />
      {loading ? (
        renderLoading()
      ) : (
        <Table height={300} data={data} onRowClick={handleClick}>
          {columns.map((column) => {
            const { key, label, ...rest } = column;
            return (
              <Column {...rest} key={key}>
                <HeaderCell>{label}</HeaderCell>
                <Cell dataKey={key} />
              </Column>
            );
          })}
        </Table>
      )}
    </div>
  );
}
