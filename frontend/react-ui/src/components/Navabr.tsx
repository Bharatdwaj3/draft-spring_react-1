

function Navbar() {
  return (
    <>
        <div className="h-[100px] w-[1469px] bg-lime-400">
          <div className="bg-red-100 w-full h-full flex flex-row">
            <div id="navLeft" className="w-[50%] h-full bg-fuchsia-500 left-0 flex flex-row gap-2 ml-4">
                <div className="h-full w-[190px] bg-amber-600">
                  Home
                </div>
                <div className="h-full w-[190px] bg-amber-600">
                  About
                </div>
                <div className="h-full w-[190px] bg-amber-600">
                  Content
                </div>
                <div className="h-full w-[190px] bg-amber-600">
                  User
                </div>
            </div>
            <div id="navRight" className="w-[50%] h-full bg-fuchsia-500 right-0 flex flex-row-reverse ">
                <div className="mr-12 h-full w-[190px] bg-amber-600">ii</div>
            </div>
          </div>
        </div>
    </>
  )
}

export default Navbar