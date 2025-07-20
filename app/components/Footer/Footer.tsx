
const Footer = async () => {
  return (
    <footer className="footer mt-auto flex justify-around py-3 relative z-20 text-fnbg-purple font-bold" style={{ bottom: '0', width: '100%' }}>
      <div>
        Fabian Berger<br />
        Jenaer Straße 1<br />
        91058 Erlangen
      </div>
      <div className="my-auto text-center">
        © 2025 - Fabian Berger
      </div>
      {/* <div>
        {posts.edges[0].node.title}
      </div> */}
    </footer>
  );
};

export default Footer;
