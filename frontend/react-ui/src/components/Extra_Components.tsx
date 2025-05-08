import ReactPaginate from "react-paginate";

const genres = [
  { id: 28, name: "Action" },
  { id: 12, name: "Adventure" },
  { id: 16, name: "Animation" },
  { id: 35, name: "Comedy" },
  { id: 80, name: "Crime" },
  { id: 99, name: "Documentary" },
  { id: 18, name: "Drama" },
  { id: 10751, name: "Family" },
  { id: 14, name: "Fantasy" },
  { id: 36, name: "History" },
  { id: 27, name: "Horror" },
  { id: 10402, name: "Music" },
  { id: 9648, name: "Mystery" },
  { id: 10749, name: "Romance" },
  { id: 878, name: "Science Fiction" },
  { id: 10770, name: "TV Movie" },
  { id: 53, name: "Thriller" },
  { id: 10752, name: "War" },
  { id: 37, name: "Western" }
];

export const Genre({ setGenre }) {


 
  return (
    <>
      <div className="accordion-item">
        <h2 className="accordion-header">
          <button
            className="accordion-button collapsed"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#collapseTwo"
            aria-expanded="false"
            aria-controls="collapseTwo"
          >
            Genre
          </button>
        </h2>
        <div
          id="collapseTwo"
          className="accordion-collapse collapse"
          data-bs-parent="#accordionExample"
        >
          <div className="accordion-body">
            {genres.map((genre) => (
              <FilterBtn
                key={genre.id}
                name="genre"
                index={genre.id}
                item={genre.name}
                setGenre={setGenre} 
              />
            ))}
          </div>
        </div>
      </div>
    </>
  );
}


export const Search = ({ setSearch }) => {
     return (
    <>
      <div>
        <form
          className="form-inline my-2 my-lg-0"
          style={{ width: "100%", height: "125px" }}
        >
          <input
            className="form-control mr-sm-2"
            onChange={(e) => {
              setSearch(e.target.value);
            }}
            style={{
              height: "55px",
              width: "900px",
              position: "absolute",
              left: "0",
              marginLeft: "165px",
            }}
            type="search"
            placeholder="Search"
            aria-label="Search"
          />
          <button
            className="btn btn-outline-success my-2 my-sm-0"
            type="submit"
            style={{
              height: "55px",
              width: "90px",
              position: "absolute",
              right: "0",
              marginRight: "190px",
            }}
          >
            Search
          </button>
        </form>
      </div>
    </>
  );
}

export const Pagination = ({totalPages, pageNumber, setPageNumber}) => {
  return (
    <>
      <ReactPaginate
        className="pagination justify-content-center gap-4 mb-4"
        previousLabel="Prev"
        previousClassName="btn btn-primary"
        nextLabel="Next"
        nextClassName="btn btn-primary"
        pageCount={totalPages?totalPages:totalPages} 
        pageClassName="page-item"
        pageLinkClassName="page-link"
        onPageChange={(page)=>{setPageNumber(page.selected+1);}}
      />
    </>
  )
}

export const Filter = ({setGenre}) => {
  return (
    <>
      <div className="col-3">
    <div className="p-3 border">
      <div className="text-center fw-bold fs-4 mb-4">Filter</div>
      <div style={{ cursor: "pointer" }} className="text-primary text-center text-decoration-underline">
        Clear Filters
      </div>
      <div className="accordion" id="accordionExample">
        <Genre setGenre={setGenre}/>
      </div>
    </div>
  </div>  
    </>
  )
}



export const Convert = () => {
  return (
    <>
        
    </>
  )
}

export const FilterBtn({ name, index, item, setGenre }) {
  return (
    <div className="form-check">
      <input
        onClick={() => setGenre(index)}
        className="form-check-input"
        type="radio"
        name={name}
        id={`${name}-${index}`}
      />
      <label className="btn btn-outline-primary" htmlFor={`${name}-${index}`}>
        {item}
      </label>
    </div>
  );
}
