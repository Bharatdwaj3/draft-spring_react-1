import axios from "axios"
import { useState,useEffect } from 'react'

import { Link } from "react-router-dom";

export const BookCard = (data, page, columns = 4, limit, customStyles) => {
  
    const columnClass = `col-${12 / columns}`;
    const itemsToDisplay = (limit === Infinity) ? data : data.slice(0, limit);
   return (
        <>
            {itemsToDisplay.map((item) => {
                const title = item.title || item.name;
                const releaseDate = item.release_date || item.first_air_date;

                return (
                    <div key={item.id} className={`${columnClass} mb-5`}>
                        <Link to={`${page}${item.id}`} className="">
                            <div
                                style={{
                                    height: "350px",
                                    width: "100%",
                                    backgroundColor: "gray",
                                    position: "relative",
                                    ...customStyles?.outerDiv,
                                }}
                            >
                                <div
                                    style={{
                                        backgroundColor: "blue",
                                        height: "300px",
                                        width: "100%",
                                        position: "absolute",
                                        top: "0",
                                        ...customStyles?.imageWrapper,
                                    }}
                                >
                                    < img
                                        style={{
                                            height: "100%",
                                            width: "100%",
                                            ...customStyles?.image,
                                        }}
                                          src={item.poster_path?`https://image.tmdb.org/t/p/w500${item.poster_path}`:Image}
                                        alt={item.poster_path ? item.title :  "NO  Image!!"}
                                           
                                    />
                                    <div
                                        style={{
                                            backgroundColor: "rgba(0, 0, 0, 0.5)",
                                            height: "100%",
                                            color: "white",
                                            width: "100%",
                                            position: "absolute",
                                            top: "0",
                                            ...customStyles?.overlay,
                                        }}
                                    >
                                        {item.original_language && (
                                            <h1
                                                className="badge bg-warning"
                                                style={{
                                                    fontSize: "0.75rem",
                                                    color: "black",
                                                    fontFamily: "sans",
                                                    backdropFilter: "blur(2px)",
                                                    marginTop: "0",
                                                    position: "absolute",
                                                    top: "19px",
                                                    right: "0",
                                                    ...customStyles?.languageBadge,
                                                }}
                                            >
                                                {item.original_language.toUpperCase()}
                                            </h1>
                                        )}

                                        {releaseDate && (
                                            <h1
                                                className="badge bg-warning"
                                                style={{
                                                    fontSize: "0.75rem",
                                                    color: "black",
                                                    fontFamily: "mono",
                                                    backdropFilter: "blur(2px)",
                                                    marginTop: "24px",
                                                    position: "absolute",
                                                    bottom: "0",
                                                    left: "0",
                                                    marginBottom: "12px",
                                                    ...customStyles?.dateBadge,
                                                }}
                                            >
                                                {new Date(releaseDate).toLocaleDateString("en-GB", {
                                                    day: "numeric",
                                                    month: "long",
                                                    year: "numeric",
                                                })}
                                            </h1>
                                        )}

                                        {item.vote_average && (
                                            <h1
                                                className="badge bg-warning"
                                                style={{
                                                    fontSize: "0.75rem",
                                                    color: "black",
                                                    fontFamily: "mono",
                                                    backdropFilter: "blur(2px)",
                                                    marginTop: "24px",
                                                    position: "absolute",
                                                    bottom: "0",
                                                    right: "0",
                                                    marginBottom:"12px",
                                                    ...customStyles?.ratingBadge,
                                                }}
                                            >
                                                {item.vote_average.toFixed(1)}
                                            </h1>
                                        )}
                                    </div>
                                </div>
                                <div
                                    style={{
                                        marginTop: "290px",
                                        height: "62px",
                                        width: "100%",
                                        backgroundColor: "black",
                                        position: "absolute",
                                        bottom: "0",
                                        opacity: "0.5",
                                        ...customStyles?.titleWrapper,
                                    }}
                                >
                                    <h1
                                        style={{
                                            fontSize: "1rem",
                                            color: "white",
                                            fontFamily: "serif",
                                            backdropFilter: "blur(2px)",
                                            marginTop: "12px",
                                            textAlign: "center",
                                            ...customStyles?.title,
                                        }}
                                    >
                                        {title}
                                    </h1>
                                </div>
                            </div>
                        </Link>
                    </div>
                );
            })}
        </>
    );
}


export const BooksList() {
  const [trendMovie, settrendMovie] = useState([]);
  const [trendTV, settrendTV] = useState([]);

  const publicKey = import.meta.env.VITE_PUBLIC_KEY;


useEffect(() => {
    async function fetchTrendingMovies() {
        try {
            const Murl = `https://api.themoviedb.org/3/trending/movie/day?language=en-US&api_key=${publicKey}`;
            const response = await axios.get(Murl);
            settrendMovie(response.data.results);
            console.log(response.data);
        } catch (error) {
            console.error("Error fetching trending movies:", error);
        }
    }

    fetchTrendingMovies();
}, [publicKey]);

useEffect(() => {
    async function fetchTrendingTVShows() {
        try {
            const TVurl = `https://api.themoviedb.org/3/trending/tv/day?language=en-US&api_key=${publicKey}`;
            const response = await axios.get(TVurl);
            settrendTV(response.data.results);
            console.log(response.data);
        } catch (error) {
            console.error("Error fetching trending TV shows:", error);
        }
    }

    fetchTrendingTVShows();
}, [publicKey]);

  return (
    <>
      
       
      <div className="container-fluid">
        <div className="row justify-content-center">
          <div
            style={{
              background: "radial-gradient(blue, gray)",
              height: "960px",
              width: "1260px",
              marginBottom: "90px",
            }}
          >
            <div className="pt-5">
              <div
                style={{
                  marginBottom: "90px",
                  height: "90px",
                  width: "500px",
                  borderBottom: "12px solid black",
                  marginLeft: "auto",
                  marginRight: "auto",
                }}
              >
                <h1
                  style={{
                    fontFamily: "sans",
                    textAlign: "center",
                    paddingTop: "20px",
                    color: "black",
                  }}
                >
                  Movies :
                </h1>
              </div>
              <div className="container">
                <div className="row">
                  <BookCard
                    data={trendMovie}
                    page="/discover/movies/"
                    columns={6}
                    limit={12}
                    customStyles={{
                      outerDiv: { height: "250px", marginTop: "2px" },
                      imageWrapper: { height: "200px" },
                    }}
                  />
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div className="container-fluid">
        <div className="row justify-content-center">
          <div
            style={{
              background: "radial-gradient(blue, gray)",
              height: "960px",
              width: "1260px",
              marginBottom: "90px",
            }}
          >
            <div className="pt-5">
              <div
                style={{
                  marginBottom: "90px",
                  height: "90px",
                  width: "500px",
                  borderBottom: "12px solid black",
                  marginLeft: "auto",
                  marginRight: "auto",
                }}
              >
                <h1
                  style={{
                    fontFamily: "sans",
                    textAlign: "center",
                    paddingTop: "20px",
                    color: "black",
                  }}
                >
                  TV Shows :
                </h1>
              </div>
              <div className="container">
                <div className="row">
                  <BookCard
                    data={trendTV}
                    page="/discover/tv_shows/"
                    columns={6}
                    limit={12}
                    customStyles={{
                      outerDiv: { height: "250px", marginTop: "2px" },
                      imageWrapper: { height: "200px" },
                    }}
                  />
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export const BookDetail = () => {
  return (
    <>
        
    </>
  )
}
export const BookSearch = () => {
  return (
    <>
        
    </>
  )
}

